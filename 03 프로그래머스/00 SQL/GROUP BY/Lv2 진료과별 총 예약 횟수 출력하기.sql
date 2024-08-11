
-- Level 2

-- 진료과 코드 별 (AS 진료과 코드) 환자 수 (AS 5월예약건수)
    -- 2022년 5월에 예약한 환자
    -- 환자수를 기준으로 오름차순 정렬, 같다면 진료과 코드를 기준으로 오름차순 정렬
    

SELECT MCDP_CD AS '진료과 코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT 
WHERE APNT_YMD LIKE '2022-05-%'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, MCDP_CD ASC

SELECT MCDP_CD AS '진료과 코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT 
WHERE DATE_FORMAT(APNT_YMD, "%Y-%m") = '2022-05'
GROUP BY MCDP_CD
ORDER BY 5월예약건수 ASC, MCDP_CD ASC