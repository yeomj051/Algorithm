-- 코드를 작성해주세요
SELECT COUNT(ID) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE HAVING AVG(LENGTH) >= 33
ORDER BY FISH_TYPE