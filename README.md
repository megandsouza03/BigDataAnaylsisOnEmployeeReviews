# INFO 7250 Engineering Big-Data Systems

## Dataset 
[Google, Amazon and more Employee Reviews](https://www.kaggle.com/petersunga/google-amazon-facebook-employee-reviews)

This dataset contains employee reviews separated into the following categories:
* Index: index
* Company: Company name
* Location : This dataset is global, as such it may include the country's name in parenthesis
* Date Posted: in the following format MM DD, YYYY
* Job-Title: This string will also include whether the reviewer is a 'Current' or 'Former' Employee at the time of the review
* Summary: Short summary of employee review
* Pros: Pros
* Cons: Cons
* Overall Rating: 1-5
* Work/Life Balance Rating: 1-5
* Culture and Values Rating: 1-5
* Career Opportunities Rating: 1-5
* Comp & Benefits Rating: 1-5
* Senior Management Rating: 1-5
* Helpful Review Count: A count of how many people found the review to be helpful
* Link to Review : This will provide you with a direct link to the page that contains the review.


## Analysis Performed 

* Hadoop MapReduce Jobs

## Technologies / Libraries Used

* Hadoop 2.9.2
* Diction : A java english dictionary library based on RiTa WordNet
* Tableau 
* Excel 

## Visualization 

### Total Reviews 
Which company has the most Reviews on Glassdoor? 
<p align="left">
<img width="438" alt="pieTotalReviews" src="https://user-images.githubusercontent.com/38237395/56101576-25750280-5ef3-11e9-97b2-053e24746c6b.png">
 </p>

### Current or Former Employee
<img width="545" alt="pieFC" src="https://user-images.githubusercontent.com/38237395/56101625-d24f7f80-5ef3-11e9-9f04-2e2fe92647bf.png">

### Yearly Growth of Reviews
<img width="691" alt="yearlyCount" src="https://user-images.githubusercontent.com/38237395/56101668-4558f600-5ef4-11e9-810f-d4d5984bf303.png">

### Ratings of Companies in different departments 
<img width="738" alt="Stars" src="https://user-images.githubusercontent.com/38237395/56101506-5acd2080-5ef2-11e9-8f91-93eda19371a9.png">

### Overall-Ratings 
<img width="456" alt="overall Ratings" src="https://user-images.githubusercontent.com/38237395/56101779-74bc3280-5ef5-11e9-9cfc-366b919c2a14.png">

### WordCloud of Summary 
<img width="972" alt="wcSummary" src="https://user-images.githubusercontent.com/38237395/56101926-b4cfe500-5ef6-11e9-8a1a-d39ddfc7a2be.png">

### Sentiment Analysis of Summary
Polarity in Summary 
Values Ranges [0: Negative , 4: Positive]

Sentiment Analysis using Standford Core NLP {Pipeline used tokenize, split, parse, sentiment}
<img width="707" alt="SentimentAnaylsis" src="https://user-images.githubusercontent.com/38237395/56178585-d00f2300-5fd0-11e9-87aa-8ae446d77349.png">


### Advice to Managment JSON
Data Organization Patterns- Structured to Hierarchical

<img width="972" alt="AdviceToMngemtJSON" src="https://user-images.githubusercontent.com/38237395/56178956-187b1080-5fd2-11e9-9308-a40cbdeb9be3.png">


### Secondary Sorting
KEY {Company : Place}
MapReduce Job that listing the total number of reviews Grouped by Company and Sorted by Places.
<img width="590" alt="SecSorting" src="https://user-images.githubusercontent.com/38237395/56843748-69f98a00-6873-11e9-9baf-e39bfeb43e8c.png">

### Average Overall Ratings {Top 2} using PIG

<img width="209" alt="AverageRatings" src="https://user-images.githubusercontent.com/38237395/56843759-9e6d4600-6873-11e9-9af9-1509e7ec9733.png">

### Filtering the Most Helpful Reviews using PIG 

<img width="1279" alt="HelpfulReviews" src="https://user-images.githubusercontent.com/38237395/56843877-0bcda680-6875-11e9-9d4f-c1ade335714b.png">
