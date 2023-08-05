library(readr)
BobRoss <- read.csv("BobRossPaintings.csv", stringsAsFactors = TRUE)
View(BobRoss)
library(arules)
library(arulesViz)

names(BobRoss)

BR = as.matrix(BobRoss[,-c(1:4)])
View(BR)
br.trans = as(BR,"transactions")                   

itemFrequencyPlot(br.trans)

rules = apriori(br.trans, parameter = list(supp=.1, conf = .8, target = "rules") )
inspect(rules)

br.quality = quality(rules)
br.subset = rules[br.quality$lift>3]
inspect(br.subset)

br.lift = sort(br.subset, by = "lift")
inspect(br.lift)

plot(br.lift, method = "graph")
plot(br.lift, method = "graph", engine='interactive')

itemFrequencyPlot(br.trans, topN = 6)

Clouds = apriori(br.trans,appearance=list(default="lhs",rhs="CLOUDS"), parameter = list(supp=.1))  
inspect(sort(Clouds,by="support"))

plot(Clouds, method = "graph")
plot(Clouds, method = "graph", engine='interactive')


#Part2
Sales <- read_csv("Online_Sales_Cleaned.csv") #Strings as factors?
Online = read.transactions(file.choose(),format="basket",sep=",")
itemFrequencyPlot(Online, topN = 30)

online.rules = apriori(Online, parameter = list(supp=.015, conf = .5, minlen = 2))
inspect(online.rules)

onqu = quality(online.rules)
on.s = online.rules[onqu$support> 0.01]

inspect(sort(on.s, by = "lift")[1:20])

Skull.rules = apriori(Online, appearance=list(default="lhs",rhs="LUNCH BAG BLACK SKULL"),
                      parameter =  list(supp=0.01, conf=0.5))
inspect(Skull.rules)
