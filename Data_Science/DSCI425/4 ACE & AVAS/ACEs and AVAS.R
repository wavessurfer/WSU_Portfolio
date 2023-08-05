
library(readr)
Mammals <- read_csv("Mammals.csv")
View(Mammals)

install.packages('acepack')
library(acepack)

plot(Mammals$Body,Mammals$Brain,xlab="Body Weight (kg)",ylab="Brain Weight (g)",pch=20)

#Interactive clicking on plot to know the ID(species)
identify(Mammals$Body,Mammals$Brain,Mammals$Species)

hist(Mammals$Body)
hist(Mammals$Brain)

### USING ACE FUNCTION ###

ace.brain <- ace(Mammals$Body, Mammals$Brain)
names(ace.brain)
ace.brain$rsq

#Compare linar model Rsq vs Ace Rsq
summary(lm(Mammals$Brain ~ Mammals$Body))
