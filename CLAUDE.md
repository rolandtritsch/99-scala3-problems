# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

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