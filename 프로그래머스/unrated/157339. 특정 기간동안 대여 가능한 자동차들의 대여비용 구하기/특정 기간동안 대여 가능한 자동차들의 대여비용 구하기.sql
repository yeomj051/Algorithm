-- 코드를 입력하세요
SELECT C.CAR_ID, C.CAR_TYPE, ROUND(C.DAILY_FEE*30*(1-(D.DISCOUNT_RATE/100))) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN D 
ON C.CAR_TYPE = D.CAR_TYPE
WHERE C.CAR_TYPE IN("세단","SUV")
    AND D.DURATION_TYPE = "30일 이상" 
    AND C.CAR_ID NOT IN (
        SELECT R.CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY R
        WHERE R.START_DATE BETWEEN "2022-11-01" AND "2022-11-30"
        OR R.END_DATE BETWEEN "2022-11-01" AND "2022-11-30"
        OR (R.START_DATE <'2022-11-01' AND R.END_DATE > '2022-11-30')
        )
    AND C.DAILY_FEE*30*(1-(D.DISCOUNT_RATE/100))>=500000 AND C.DAILY_FEE*30*(1-(D.DISCOUNT_RATE/100))<2000000
GROUP BY C.CAR_ID 
ORDER BY FEE DESC, C.CAR_TYPE ASC, C.CAR_ID DESC;