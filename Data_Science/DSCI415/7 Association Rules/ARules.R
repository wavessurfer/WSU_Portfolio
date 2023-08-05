library(readr)
Golf <- read.csv("Golf.csv", stringsAsFactors = TRUE)
View(Golf)

library(arules)
library(arulesViz)
golf.trans = as(Golf, "transactions")
summary(golf.trans)
View(golf.trans)

itemFrequencyPlot(golf.trans)

golf.rules = apriori(golf.trans, parameter = list(supp=1/14, conf = .8, target = "rules"))
inspect(golf.rules)

golf.sort = sort(golf.rules, by = "lift")
inspect(golf.sort)

golf2 = subset(golf.rules, subset(rhs) %in% "play=yes")
inspect(sort(golf2, by = "support"))

plot(sort(golf2, by = "support"), method = "graph")

