library(readr)
library(dplyr)

Saratoga <- read_csv("SaratogaNY_Homes.csv")
Saratoga$Waterfront  = as.factor(Saratoga$Waterfront)
Saratoga$New.Construct = as.factor(Saratoga$New.Construct)
Saratoga$Central.Air = as.factor(Saratoga$Central.Air)
Saratoga$Fuel.Type = as.factor(Saratoga$Fuel.Type)
Saratoga$Heat.Type = as.factor(Saratoga$Heat.Type)
Saratoga$Sewer.Type = as.factor(Saratoga$Sewer.Type)

spec(SaratogaNY_Homes)

randomGrove <- function(mydata, model.formula="Price ~ .", Feature.proportion = 0.5, GroveNumber = 10){
  #Purpose: fit a multiple linear regression model with a random
  #subset of features (not all of them)
  #
  #Required packages:
  #   -dplyr is required for summaries
  # mydata = data.frame that includes the data for fitting
  #          - response should be in first column
  #          - remaining features in remaining columns
  #          - data.frame should have row.names specifed for tracking of observations
  # model.formula = formula used for model fitting
  #Feature.proportion = the proportion o f features to be used for modeling.
  # This value shoulde be > 0 & < 1
  #Output: model results -RMSE
  
  #Initiate an output data.frame
  output <- data.frame(ID = factor(), Actual = numeric(), Predicted = numeric())
  
  #Get the size of the data.frame being used for modeling
  mydata.size <- dim(mydata)
  
  for ( i in 1:GroveNumber) {
      #Make a random selection of features
      which.features <- sort( sample(2:mydata.size[2], size=floor(mydata.size[2]* Feature.proportion), replace=F) )
      
      #Get a reduced mydata data.frame for Grove aspect of fitting
      mydata.Grove <- mydata[, c(1,which.features)]
      
      #Fit the lm object
      myGrovemodel <- lm(as.formula(model.formula), data=mydata.Grove)
      
      #Use model to make predictions for data in validation set
      predicted.Grove <- data.frame(predict(myGrovemodel, newdata = mydata.Grove))
      
      #Save the predicted from each sampling
      output <- rbind(output, data.frame(ID = row.names(mydata.Grove), Actual = mydata.Grove[,1], Predicted = predicted.Grove[,1]))
      }
  
  names(output) <- c("ID", "Actual", "Predicted")
      
  final.output <- (
                    output
                    %>% group_by(ID)
                    %>% summarize(Actual = mean(Actual), Predicted = mean(Predicted))
  )
  
  return(final.output)
  
}

output <- randomGrove(Saratoga, "Price ~ .")
View(output)
