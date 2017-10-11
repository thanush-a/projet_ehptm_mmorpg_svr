JC = javac
JCR = java

.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	TestMMORPG.java	

# 
# make par defaut
# 
default: classes
		java TestMMORPG

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class