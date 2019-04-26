reviews = LOAD '/Users/megandsouza/Desktop/Spring2019/BigData/0Project/BigDataAnaylsisOnEmployeeReviews/BigDataAnaylsisOnEmployeeReviews/employee_reviews.csv' USING PigStorage(',') as (sno,company,location,dates,jobtitle,summary,pros,cons,advicetomgmt,overallratings,workbalancestars,culturevaluesstars,carreropportunitiesstars,compbenefitstars,seniormangemnetstars,helpfulcount,link);
reviewCompany = Group reviews by company;
averageStars= FOREACH reviewCompany GENERATE  $0,AVG(reviews.overallratings);
ordered = order averageStars by $1 desc;
topTwo= limit ordered 2;
dump topTwo;