-- 코드를 입력하세요
# SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES*B.PRICE) AS TOTAL_SALES
# FROM BOOK_SALES S, BOOK B, AUTHOR A
# WHERE B.BOOK_ID = S.BOOK_ID AND B.AUTHOR_ID = A.AUTHOR_ID AND S.SALES_DATE BETWEEN "2022-01-01" AND "2022-01-31"
# GROUP BY S.BOOK_ID, B.CATEGORY
# ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;

SELECT
b.AUTHOR_ID,
a.AUTHOR_NAME,
b.CATEGORY,
SUM(bs.SALES * b.PRICE) TOTAL_SALES
FROM
BOOK_SALES bs 
JOIN BOOK b
ON bs.BOOK_ID = b.BOOK_ID
JOIN AUTHOR a
ON b.AUTHOR_ID = a.AUTHOR_ID
WHERE bs.SALES_DATE BETWEEN "2022-01-01" AND "2022-01-31"
GROUP BY b.AUTHOR_ID, b.CATEGORY
ORDER BY b.AUTHOR_ID, b.CATEGORY DESC;