# Demo Script

- Walk people through the UI
  - VsCode (on steroids)
    - Point: Left, Middle, Right
- My plugins (usual stuff: Metals, Github Lense, ...)
- Codeium/Cascade (plugin) on the right
  - Chat mode (like chatGPT)
    - Have a discussion, generate code, ...
    - BUT ... do not use "tools" to "do" anything (create/write files, compile code, ...)
    - Point: To Chat
  - Write mode (like GH Edits; plus running local tools)
    - Point: To Write
    - Action: Click-on toggle
- To get good results you need good prompts and good contexts
- Let's talk about contexts first ...
  - The entire workspace
  - All open files/tabs
    - Action: Show all the @s
  - Marked lines
    - Use a scratch buffer/file
    - Action: Who is Roland? What time is it?
      - With Chat and Write mode enabled
      - Try to get the time from ChatGPT
- So what is this code all about? The 99-scala-problems!
  - Action: Show the PDF
  - Action: Show P01 and P01Test
  - Action: Run tests
- Now lets take a look at the different ways to prompt the AI ...
  - Code completion (with comments/hints)
    - Action: Add another test with ten values
  - Commands (or instructions)
    - Action: Add another test to test for an empty list
  - Chat/Write (with lines and files)
    - Action: Ask Chat to explain the property based test
    - Action: Break the compile and ask Chat about it
    - Action: Switch to Write and ask to fix it
    - Action: Break the test and ask to fix it
- As you can imagine you can obviously also just use Cascade to solve bigger problems (generate
  apps)
  - Today, right now/here its not the right place to talk about this, because it is too big. And
    there a lots of examples available already
- Now lets refactor the code
  - Action: Let's refactor the tests. Please create one big test file with all tests from P01 to P50
    in it. Let;s call this file PAllTest.scala. Make sure PAllTest passes all tests. Then delete all
    the single test files (P01 to P50).
- Now let's come to the bonus section
  - Remember that the answer to "Who is Roland?" was weak. Let's fix that
  - Cascade has (already) a lot of tools at it's disposal
  - What if there would be a way to extend Cascade? Give it access to even more tools?
  - Who knows what an MCP server is?
  - And guess what? There is an MCP server for "Who is Roland?"!
  - Action: Install the MCP server
  - Action: Ask the question again
