# Nutrition Data

A simple web service which supports searching and sorting nutrition data.  Query results are returned as a list of foods and drinks, formatted as a JSON document.

Data comes from https://www.kaggle.com/datasets/trolukovich/nutritional-values-for-common-foods-and-products?resource=download 
and is available under the [CCO: Public Domain](https://creativecommons.org/publicdomain/zero/1.0/) licence.


## Querying the data
A number of query parameters are available to customize the search criteria. All query parameters are optional and
may be applied in any order. The full list of query parameters is:

* `fatRating=Low|Medium|High` - Filter by fat rating.  When this parameter is omitted, all entries are returned.
Categorization based on https://www.heartuk.org.uk/low-cholesterol-foods/saturated-fat
* `minCalories` - Items will match if they are greater than or equal to the minimum calories.
* `maxCalories` - Items will match if they are less than or equal to the maximum calories.
* `limit` - Limit the number of items returned. Must be a positive integer.
* `sort` - Items may be sorted by `name` or `calories` or both. The sort parameter is specified as the name of the field,
followed by an underscore (`_`) and then the sort order (`asc` or `desc`), e.g. `calories_desc`. To sort by both name
and calories, specify two sort parameters in the query string, one for each field. The order of the fields 
determines the final order of the items, e.g. if sorting by calories descending and name ascending, the second sort 
parameter is only used when the calories are equal.
