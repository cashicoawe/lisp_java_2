all:
	javac Entry.java
	java Entry

lisp:
	javac Entry.java
	cat lisp | java Entry

.PHONY: lisp