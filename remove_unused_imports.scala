import java.nio.file.*
import scala.jdk.CollectionConverters.*

@main def removeUnusedImports() = {
  val testDir = Paths.get("/home/yoda/Development/Home/99-scala3-problems/test/src/ninetynine")
  val files = Files.list(testDir).iterator.asScala.toList
  
  files.foreach { path =>
    val fileName = path.getFileName.toString
    if (fileName.endsWith("Test.scala") && fileName != "P22Test.scala") {
      val content = Files.readString(path)
      val newContent = content.replaceAll("import scala.util.Random\\n", "")
      Files.writeString(path, newContent)
      println(s"Removed unused import from $fileName")
    }
  }
}
