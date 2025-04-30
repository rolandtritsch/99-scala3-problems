# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview
This repository contains solutions to the 99 Scala Problems, a collection of programming exercises inspired by the 99 Prolog Problems. The problems increase in difficulty from simple list manipulation to more complex problems involving graphs, trees, and logic.

## Build Commands
- Build and test: `./mill test.compile`
- Run all tests: `./mill test`
- Run tests excluding ignored tests: `./mill test --exclude-tags=ignore`
- Watch mode: `./mill --watch test --exclude-tags=ignore`
- Run single test: `./mill test.testOnly ninetynine.P01Test`
- Format code: `./mill mill.scalalib.scalafmt.ScalafmtModule/reformatAll`
- Run scalafix: `./mill main.fix`

## Code Style Guidelines
- Use Scala 3 (version 3.6.3) with indentation-based syntax
- Follow scalafmt config: 2-space indentation, 100 char line width
- Use end markers for classes/objects (required when >5 lines long)
- Prefer functional style: avoid while-loops and for-comprehensions
- Use ScalaCheck for property-based testing
- Document classes and methods with ScalaDoc comments
- Organize imports carefully (imports are managed by scalafix)
- Follow the extensive scalafix rules enabled in the project
- Pattern match instead of using null checks or explicit conditionals
- Use explicit return types on public methods
- Use scala-logging for any logging needs

## Project Structure
- `main/src/ninetynine/`: Contains implementations of each problem (P01.scala to P99.scala)
- `main/test/src/ninetynine/`: Contains test cases for each problem
- `docs/`: Contains documentation including the original problem descriptions

## Implementation Guidelines
- Solutions should be implemented in a functional style
- Use pattern matching and recursion when appropriate
- Include proper ScalaDoc comments with @param, @return, etc.
- Implement tailrec functions where possible
- Each solution should be accompanied by corresponding tests with ScalaCheck properties

## Testing Guidelines
- All tests should pass when running `./mill test`
- Use ScalaCheck for property-based testing
- Tests should cover edge cases and typical use cases
- Some tests may be marked with `@ignore` tags for work in progress

## Development Workflow
1. Choose a problem to implement
2. Create tests first in the corresponding test file
3. Implement the solution in the corresponding source file
4. Run tests to verify correctness
5. Format the code with scalafmt and check with scalafix
6. Ensure all tests pass before committing