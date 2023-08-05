from pyspark.sql.types import StructType, StructField, TimestampType, DoubleType, StringType

uber_schema = StructType([StructField('Date/Time', TimestampType(), True),
                          StructField('Lat', DoubleType(), True),
                          StructField('Lon', DoubleType(), True),
                          StructField('Base', StringType(), True)])
                          
uber_datetime_format = 'M/d/yyyy H:mm:ss'