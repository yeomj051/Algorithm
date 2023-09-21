-- 코드를 입력하세요
# SELECT H.HISTORY_ID, ROUND(C.DAILY_FEE*(DATEDIFF(H.END_DATE, H.START_DATE)+1) *(1-P.DISCOUNT_RATE/100)) AS FEE
# FROM CAR_RENTAL_COMPANY_CAR C 
# JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H ON C.CAR_ID = H.CAR_ID
# LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE
# WHERE C.CAR_TYPE = "트럭" AND (DATEDIFF(H.END_DATE, H.START_DATE)+1) >= P.DURATION_TYPE
# GROUP BY H.HISTORY_ID
# ORDER BY FEE DESC, HISTORY_ID DESC;

SELECT history_id
     , CASE 
            WHEN plan_id IS NULL THEN FLOOR(daily_fee * (DATEDIFF(end_date, start_date) + 1))
            ELSE FLOOR(daily_fee * (DATEDIFF(end_date, start_date) + 1) * (1 - discount_rate / 100)) END AS fee
FROM car_rental_company_rental_history AS h
    INNER JOIN car_rental_company_car AS c ON h.car_id = c.car_id
    LEFT JOIN car_rental_company_discount_plan AS p 
    ON c.car_type = p.car_type
    AND (CASE 
            WHEN DATEDIFF(end_date, start_date) + 1 BETWEEN 7 AND 29 THEN plan_id = 10
            WHEN DATEDIFF(end_date, start_date) + 1 BETWEEN 30 AND 89 THEN plan_id = 11
            WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN plan_id = 12 END)
WHERE c.car_type = '트럭'
GROUP BY 1
ORDER BY 2 DESC, 1 DESC