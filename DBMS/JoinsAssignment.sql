use coviddb;
-- Q1
SELECT 
    `State/UnionTerritory`, 
    Confirmed
FROM `covid_19_india - covid_19_india`
WHERE Date = '2020-02-04' 
ORDER BY Confirmed DESC
LIMIT 1;

-- Q2
SELECT 
    cd.country_id, 
    cd.date, 
    cd.death_count, 
    cv.vaccination_status
FROM covid_deaths cd
LEFT JOIN covid_vaccines cv 
    ON cd.country_id = cv.country_id 
    AND cd.date = cv.date;
    
    SELECT 
    cont.continent_name, 
    SUM(cc.deaths) AS total_deaths
FROM covid_cases cc
INNER JOIN countries c 
    ON cc.country_id = c.country_id
INNER JOIN continents cont 
    ON c.continent_id = cont.continent_id
GROUP BY cont.continent_name;

SELECT 
    date, 
    AVG(new_deaths) AS avg_daily_deaths
FROM covid_cases
GROUP BY date
ORDER BY date ASC;

SELECT 
    c.country_name,
    (MAX(cc.confirmed_cases) * 100.0 / c.population) AS infection_rate
FROM covid_cases cc
INNER JOIN countries c 
    ON cc.country_id = c.country_id
GROUP BY c.country_name, c.population
ORDER BY infection_rate DESC;


