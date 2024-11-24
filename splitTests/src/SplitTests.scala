import scala.io.Source
import java.io.{File, PrintWriter}
import scala.collection.mutable.StringBuilder

object SplitTests {
  def main(args: Array[String]): Unit = {
    val sourceFile = "test/src/ninetynine/P00Test.scala"
    val targetDir = "test/src/ninetynine"
    
    // Read the source file
    val content = Source.fromFile(sourceFile).getLines().toList
    
    // Extract imports
    val imports = content.takeWhile(!_.contains("class P00Test")).filter(_.startsWith("import"))
    
    // Process the content
    var currentProblem = ""
    var currentContent = new StringBuilder
    var inProperty = false
    var bracketCount = 0
    
    def writeTestFile(problem: String, content: String): Unit = {
      if (problem.nonEmpty) {
        val fileName = s"$targetDir/${problem}Test.scala"
        val writer = new PrintWriter(new File(fileName))
        try {
          writer.println("package ninetynine")
          writer.println()
          imports.foreach(writer.println)
          writer.println()
          writer.println(s"class ${problem}Test extends munit.ScalaCheckSuite {")
          writer.println("  val ignore = new munit.Tag(\"ignore\")")
          writer.println()
          writer.println(content)
          writer.println("}")
        } finally {
          writer.close()
        }
        println(s"Created $fileName")
      }
    }
    
    content.foreach { line =>
      if (line.contains("property(\"P") || line.contains("test(\"P")) {
        // Extract problem number
        val problemMatch = "P\\d+".r.findFirstIn(line).get
        if (currentProblem != problemMatch && currentProblem.nonEmpty) {
          writeTestFile(currentProblem, currentContent.toString())
          currentContent.clear()
        }
        currentProblem = problemMatch
        inProperty = true
        bracketCount = 0
      }
      
      if (inProperty) {
        currentContent.append(line + "\n")
        bracketCount += line.count(_ == '{')
        bracketCount -= line.count(_ == '}')
        
        if (bracketCount == 0 && line.trim == "}") {
          inProperty = false
        }
      }
    }
    
    // Write the last test file
    if (currentContent.nonEmpty) {
      writeTestFile(currentProblem, currentContent.toString())
    }
    
    // Delete the original P00Test.scala
    new File(sourceFile).delete()
    println(s"Deleted $sourceFile")
  }
}
