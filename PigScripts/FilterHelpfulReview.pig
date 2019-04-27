reviews = LOAD '/Users/megandsouza/Desktop/Spring2019/BigData/0Project/BigDataAnaylsisOnEmployeeReviews/BigDataAnaylsisOnEmployeeReviews/employee_reviews.csv' USING PigStorage(',') as (sno,company,location,dates,jobtitle,summary,pros,cons,advicetomgmt,overallratings,workbalancestars,culturevaluesstars,carreropportunitiesstars,compbenefitstars,seniormangemnetstars,helpfulcount,link);
filterHelpful= FILTER reviews BY helpfulcount > 2000;
ordered = order filterHelpful by filterHelpful.helpfulcount desc;
dump ordered;
