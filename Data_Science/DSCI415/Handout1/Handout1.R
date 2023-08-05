library(readr)
City77 <- read_csv("City77.csv")
View(City77)

#Get names of the variables
names(City77)

#old School...
hist(City77$medinc, prob=T)

City77$medinc

lines(density(City77$medinc))

density(City77$medinc)

library(ggplot2)
  
a = ggplot(City77, aes(medinc)) +
  geom_rug() +
  geom_histogram(binwidth=1000, aes(y=..density..), fill="lightblue",color="black") +
  geom_density(adjust=2, linetype=2) +
  xlab("Median Income") +
  ggtitle("Median Income for Top 77 Cities")
a 

plot(City77$poverty, City77$infmort, xlab = "Percent below Poverty Level", ylab = "Infant Mortality Rate")
lines(lowess(City77$poverty, City77$infmort), lty=2, col="lightblue", lwd=2)
abline(lm(infmort~poverty, data = City77), lwd=2)
identify(City77$poverty, City77$infmort, labels = row.names(City77))
#[1] 19 44 33 9

title(main="Infant Mortality vs Poverty LEvel")

b = ggplot(City77, aes(poverty, infmort)) + 
  geom_point() + 
  geom_smooth() + 
  geom_text(aes(label=row.names(City77)), size = 5) +
  xlab("Poverty") +
  ylab("Infant Mortality") +
  ggtitle("Infant Mortality vs. Poverty Rate")
b

library(readr)
Olives <- read_csv("Olives.csv")
View(Olives)

c = ggplot(Olives, aes(Area.Name, Oleic)) +
    geom_boxplot(fill="lightblue") +
    xlab("Area Name") +
    ylab("Oleic Acid") +
    ggtitle("Oleic Acid vs Growing Area")
c

d = ggplot(Olives,aes(Area.Name, Oleic)) +
  geom_violin(fill="lightblue")+
  xlab(("Area Name"))+ 
  ylab("Oleic Acid") + ggtitle ("Oleic Acid vs Growing Area")
d

margin.table(UCBAdmissions, c(1,2))
prop.table(margin.table(UCBAdmissions, c (1,2)), margin = 1)

dim(City77)
attach(City77)
names(City77)
city.mat <- cbind(popdens, pctblack, pcthisp, medinc,poverty,infmort,unempl)

library(gclus)
library(MASS)
palette(rainbow(12, s = 0.6, v = 0.75))
stars(city.mat, len = .80, key.loc = c(15,1.25), main = "Starplots for US Cities", draw.segments = TRUE, labels=row.names(City77$City), cex=.7)
palette("default")

parcoord(city.mat)

library(aplpack)
par(ask=T)

faces(city.mat, nrow.plot = 5, ncol.plot = 5, labels = City77$City, cex=.9)