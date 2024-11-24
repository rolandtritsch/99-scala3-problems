import java.nio.file.*
import scala.jdk.CollectionConverters.*

@main def removeScalacheckImport() = {
  // Files that use property-based testing features
  val filesWithPropertyTests = Set(
    "P01Test.scala", "P02Test.scala", "P03Test.scala", "P04Test.scala",
    "P05Test.scala", "P06Test.scala", "P07Test.scala", "P08Test.scala",
    "P12Test.scala", "P14Test.scala", "P15Test.scala", "P16Test.scala",
    "P17Test.scala", "P19Test.scala", "P20Test.scala", "P22Test.scala",
    "P25Test.scala", "P31Test.scala", "P32Test.scala", "P33Test.scala"
  )
  
  val testDir = Paths.get("/home/yoda/Development/Home/99-scala3-problems/test/src/ninetynine")
  val files = Files.list(testDir).iterator.asScala.toList
  
  files.foreach { path =>
    val fileName = path.getFileName.toString
    if (fileName.endsWith("Test.scala") && !filesWithPropertyTests.contains(fileName)) {
      val content = Files.readString(path)
      val newContent = content.replaceAll("import org.scalacheck.Prop\\._\\n", "")
      Files.writeString(path, newContent)
      println(s"Removed ScalaCheck import from $fileName")
    }
  }
}
