
-- Level 2

-- 동물의 이름, 해당 이름이 쓰인 횟수
    -- 두번 이상 쓰인 동물 이름
    -- 이름 순으로 조회

SELECT NAME, COUNT(*) AS COUNT
FROM ANIMAL_INS
GROUP BY NAME HAVING COUNT(NAME) >= 2
ORDER BY NAME
