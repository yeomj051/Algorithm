-- 코드를 작성해주세요
SELECT COUNT(*) AS FISH_COUNT
FROM FISH_INFO F, FISH_NAME_INFO N
WHERE F.FISH_TYPE = N.FISH_TYPE AND (N.FISH_NAME = "SNAPPER" OR N.FISH_NAME = "BASS");