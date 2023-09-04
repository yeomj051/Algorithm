-- 코드를 입력하세요
# SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
# FROM APPOINTMENT
# WHERE APNT_YMD LIKE "2022-05%" 
# GROUP BY MCDP_CD
# ORDER BY '5월예약건수' ASC, '진료과코드' ASC;

SELECT mcdp_cd as "진료과 코드", count(*) as "5월예약건수"
from APPOINTMENT
where  apnt_ymd like '2022-05%'
group by mcdp_cd
order by 2, 1