import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * java.nio.file package is the new support for file I/O and for accessing the default file system.
 * This new API is very intuitive and easy to use.
 */

/*
 * What is a Path?
 *
 * Most file systems store files in a tree or hierarchical structure. At the top of the tree is one
 * or more root nodes. Under the root node, there are files and directories, which in turn can contain
 * files and subdirectories each, potentially to an almost limitless depth.
 *
 * A file is identified by its path through the file system, beginning from the root node.
 *
 * The delimiter to separate the directory names is specific to the file system.
 *
 * Linux/UNIX:
 * - /home/sally/statusReport
 *
 * Windows:
 * - C:\home\sally\statusReport
 *
 * A path is either relative or absolute.
 *
 */

/*
 * The Path class.
 *
 * Is a programmatic representation of a path in the file system. A Path object contains the file name
 * and directory list used to construct the path, and is used to examine, locate, and manipulate files.
 *
 * A Path instance reflects the underlying platform, and is not system independent. You cannot compare
 * a Path from a Solaris file system and expect it to match a Path from a Windows file system, even if 
 * the directory structure is identical and both instances locate the same relative file.
 *
 * The file or directory corresponding to the Path might not exist. You can create a Path instance and 
 * manipulate it in various ways: you can append to it, extract pieces of it, compare it to another path.
 */

/*
 * Path Operations
 */

// Creating a Path

Path path1 = Paths.get("/tmp/foo");
Path path2 = Paths.get(System.getProperty("user.dir"));
Path path3 = Paths.get("../jsh-scripts");
System.out.println(path1.toString());
System.out.println(path2.toString());
System.out.println(path3.toString());

// You can think of the Path as storing these name elements as a sequence.
// The highest element in the directory structure would be located at index 0.
// The lowest element in the directory structure would be located at index [n-1]
// Methods are available for retrieving individual elements or a subsequence of the Path using these indexes.

// Retrieving information
// None of these methods requires that the file corresponding to the Path exists.
System.out.format("toString: %s%n", path1.toString());
System.out.format("getFileName: %s%n", path1.getFileName());
System.out.format("getName(0): %s%n", path1.getName(0));
System.out.format("getNameCount: %d%n", path1.getNameCount());
System.out.format("subpath(0,2): %s%n", path1.subpath(0,2));
System.out.format("getParent: %s%n", path1.getParent());
System.out.format("getRoot: %s%n", path1.getRoot());

// Converting a Path
System.out.format("toUri: %s%n", path3.toUri());
System.out.format("toAbsolutePath: %s%n", path3.toAbsolutePath());
System.out.format("toRealPath: %s%n", path3.toRealPath());

// Comparing Paths
System.out.println(path1.equals(path2));
System.out.println(path1.startsWith("/tmp"));
System.out.println(path1.endsWith("foo"));

// Iterating a Path (implements Iterable)
for (Path s : path3.toAbsolutePath().normalize()) { // "../jsh-scripts"
    System.out.println(s);
}


/exit
