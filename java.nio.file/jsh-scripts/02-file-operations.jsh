/*
 * The Files class is the other primary entrypoint of the java.nio.file package.
 * This class offers a rich set of static methods for reading, writing,
 * and manipulating files and directories.
 * The Files methods work on instances of Path objects.
 */

/*
 * System Resources
 *
 * Many of the resources that are used in this API, such as streams or channels,
 * implement or extend the java.io.Closeable interface. A requirement of a Closeable
 * resource is that the close method must be invoked to release the resource when no
 * longer required.
 *
 * The use of try-with-resources is recommended.
 */

/*
 * Varargs
 *
 * Several Files methods accept an arbitrary number of arguments when flags are specified.
 * For example, in the following method signature, the ellipses notation after the
 * CopyOption argument indicates that the method accepts a variable number of arguments,
 * or varargs, as they are typically called: Files.move(Path, Path, CopyOption...)
 */

/*
 * Atomic operations
 */

/*
 * Method chaining
 */

// Checking files

import java.io.IOException;
import java.nio.file.*;

Path homeDir = Paths.get(System.getProperty("user.home")); // - /Users/benek

Path regularFile = homeDir.resolve("regular-file.txt");
Path file = Paths.get("/Users/benek/regular-file.txt");

// Regular file means is not a directory or a special kind of file such as a device
System.out.println(Files.isRegularFile(file));
System.out.println(Files.isReadable(file));
System.out.println(Files.isExecutable(file));

System.out.println(regularFile.toString());
System.out.println(file.toString());
System.out.println("Same? " + Files.isSameFile(regularFile, file));

/*
 * Deleting file or directory
 */

try {
    Files.delete(file);
} catch (NoSuchFileException x) {
    System.err.format("%s: no such" + " file or directory%n", file);
} catch (DirectoryNotEmptyException x) {
    System.err.format("%s not empty%n", file);
} catch (IOException x) {
    // File permission problems are caught here.
    System.err.println(x);
}

/*
 * Copying a file or directory
 */

Files.copy(regularFile, homeDir.resolve("Desktop").resolve(regularFile.getFileName()));
// CopyOptions:
// - REPLACE_EXISTING
// - COPY_ATTRIBUTES
// - NOFOLLOW_LINKS

/*
 * Moving a file or directory
 */

Files.move(regularFile, homeDir.resolve("Desktop").resolve(regularFile.getFileName()));
// CopyOptions:
// - REPLACE_EXISTING
// - ATOMIC_MOVE

/*
 * Managing Metadata
 *
 * - size(Path)
 * - isDirectory(Path, LinkOption)
 * - isRegularFile(Path, LinkOption...)
 * - isSymbolicLink(Path)
 * - isHidden(Path)
 * - getLastModifiedTime(Path, LinkOption...)
 * - setLastModifiedTime(Path, FileTime)
 * - getOwner(Path, LinkOption...)
 * - setOwner(Path, UserPrincipal)
 * - getPosixFilePermissions(Path, LinkOption...)
 * - setPosixFilePermissions(Path, Set<PosixFilePermission>)
 * - getAttribute(Path, String, LinkOption...)
 * - setAttribute(Path, String, Object, LinkOption...)
 */

/*
 * Basic File Attributes
 */

java.nio.file.attribute.BasicFileAttributes attr = Files.readAttributes(file, java.nio.file.attribute.BasicFileAttributes.class);
System.out.println("creationTime: " + attr.creationTime());
System.out.println("lastAccessTime: " + attr.lastAccessTime());
System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
System.out.println("isDirectory: " + attr.isDirectory());
System.out.println("isOther: " + attr.isOther());
System.out.println("isRegularFile: " + attr.isRegularFile());
System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
System.out.println("size: " + attr.size());


/exit
