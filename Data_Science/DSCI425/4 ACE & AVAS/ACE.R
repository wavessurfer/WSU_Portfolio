
#################################################################
#####################       Section 4      ######################
#################################################################

#Read in data
library(readr)
PCBtrout <- read_csv("PCBtrout.csv")
View(PCBtrout)


#Scale the predictor = Age
x <- scale(PCBtrout$Age)

#Scale the resposne = PCB
y <- scale(PCBtrout$PCB)

############################
# Start with the predictor

#Plot the scaled data
plot(x,y,xlab="Standardized Age", ylab="Standardized PCB")


#Plot a lowess fit
phi1.fit <- lowess(x,y,f=0.5)

#Add lowess fit to plot
lines(phi1.fit)

#Save the fitted values from lowess fit
phi1 <- phi1.fit$y


##########################
#Moving onto the response

#Plot y against  the lowess fit from above
plot(y,phi1,xlab="Standardized PCB",ylab="phi1(x)")

#Get lowess fit for this plot
theta1.fit = lowess(y,phi1,f=0.5)

#Add lowess fit to this plot
lines(theta1.fit)

#Save the fitted values from lowess fit
theta1 <- theta1.fit$y

#Fit a linear model using the two non-parametrics fits from lowess
lm1 <- lm(theta1 ~ phi1)

#Get summary of lm fit
summary(lm1)


#####################################################################
#####################################################################
#########              SECOND ITERATION      ########################


###########################
# Start with the predictor

#Plot the scaled data
plot(x,theta1,xlab="Standardized Age", ylab="theta1(y)")


#Plot a lowess fit
phi2.fit <- lowess(x,theta1, f=0.5)

#Add lowess fit to plot
lines(phi2.fit)

#Save the fitted values from lowess fit
phi2 <- phi2.fit$y


##########################
#Moving onto the response

#Plot y against  the lowess fit from above
plot(y,phi2,xlab="Standardized PCB",ylab="phi2(x)")

#Get lowess fit for this plot
theta2.fit = lowess(y,phi2,f=0.5)

#Add lowess fit to this plot
lines(theta2.fit)

#Save the fitted values from lowess fit
theta2 <- theta2.fit$y

#Fit a linear model using the two non-parametrics fits from lowess
lm2 <- lm(theta2 ~ phi2)

#Get summary of lm fit
summary(lm2)

#####################################################################
#####################################################################

#####################################################################
#####################################################################
#####################################################################
#########              THIRD ITERATION      ########################


###########################
# Start with the predictor

#Plot the scaled data
plot(x,theta2,xlab="Standardized Age", ylab="theta2(y)")


#Plot a lowess fit
phi3.fit <- lowess(x,theta2, f=0.5)

#Add lowess fit to plot
lines(phi3.fit)

#Save the fitted values from lowess fit
phi3 <- phi3.fit$y


##########################
#Moving onto the response

#Plot y against  the lowess fit from above
plot(y,phi3,xlab="Standardized PCB",ylab="phi3(x)")

#Get lowess fit for this plot
theta3.fit = lowess(y,phi3,f=0.5)

#Add lowess fit to this plot
lines(theta3.fit)

#Save the fitted values from lowess fit
theta3 <- theta3.fit$y

#Fit a linear model using the two non-parametrics fits from lowess
lm3 <- lm(theta3 ~ phi3)

#Get summary of lm fit
summary(lm3)

#####################################################################
#####################################################################
#####################################################################


###############  WHEN TO STOP: WHEN R^2 not changing much  ###########



############## Creating some plots of final step     ################

plot(sort(x),sort(phi3),xlab="Standardized Age",ylab="Final Estimate of phi(x)")
lines(sort(x),sort(phi3))

plot(sort(y),sort(theta3),xlab="Standardized PCB",ylab="Final Estimate of theta(x)")
lines(sort(y),sort(theta3))


plot(sort(phi3),sort(theta3), xlab="Phi(Age)", ylab="Theta(PCB)")


###################################################################
#Fitting a final model
lm.final <- lm(theta3~phi3)

par(mfrow=c(2,2))
plot(lm.final)


par(pty="m")

