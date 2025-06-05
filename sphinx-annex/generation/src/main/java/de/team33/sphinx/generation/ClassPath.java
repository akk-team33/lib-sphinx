package de.team33.sphinx.generation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public final class ClassPath {

    private static final Logger LOG = Logger.getLogger(ClassPath.class.getCanonicalName());

    private static final String CLASS_SUFFIX = ".class";
    private static final int CLASS_SUFFIX_LENGTH = CLASS_SUFFIX.length();

    private ClassPath() {
    }

    public static Stream<String> classNames() {
        return urls().flatMap(ClassPath::contents)
                     .filter(ClassPath::isClassEntry)
                     .filter(ClassPath::isOuterClass)
                     .map(ClassPath::toClassName);
    }

    public static Stream<URL> urls() {
        return loaders().filter(URLClassLoader.class::isInstance)
                        .map(URLClassLoader.class::cast)
                        .map(URLClassLoader::getURLs)
                        .flatMap(Stream::of);
    }

    private static String toClassName(final String entry) {
        final Path path = Paths.get(entry.substring(0, entry.length() - CLASS_SUFFIX_LENGTH));
        return StreamSupport.stream(path.spliterator(), false)
                            .map(Path::toString)
                            .collect(Collectors.joining("."));
    }

    private static boolean isOuterClass(final String entry) {
        return !entry.contains("$");
    }

    private static boolean isClassEntry(final String entry) {
        return entry.endsWith(CLASS_SUFFIX);
    }

    private static Stream<String> contents(final URL url) {
        final String urlPath = url.getPath();
        if (urlPath.endsWith(".jar"))
            return jarContents(url);
        else
            return dirContents(Paths.get(urlPath));
    }

    private static Stream<String> dirContents(final Path path) {
        if (Files.isDirectory(path)) {
            LOG.info(() -> "currently ignored: " + path);
            return Stream.empty();
        } else {
            LOG.warning(() -> "path ist not a directory: " + path);
            return Stream.empty();
        }
    }

    private static Stream<String> jarContents(final URL url) {
        final List<String> result = new LinkedList<>();
        try (final InputStream urlIn = url.openStream();
             final JarInputStream jarIn = new JarInputStream(urlIn)) {
            for (JarEntry entry = jarIn.getNextJarEntry(); null != entry; entry = jarIn.getNextJarEntry()) {
                result.add(entry.getName());
            }
        } catch (final IOException e) {
            throw new IllegalStateException("cannot read " + url, e);
        }
        return result.stream();
    }

    private static Stream<ClassLoader> loaders() {
        final List<ClassLoader> result = new LinkedList<>();
        for (ClassLoader cl = Thread.currentThread().getContextClassLoader(); null != cl; cl = cl.getParent()) {
            result.add(cl);
        }
        return result.stream();
    }
}