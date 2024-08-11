
-- Level 1

-- 동물의 아이디와 이름
    -- 아픈 동물
    -- 동물의 ID를 기준으로 오름차순

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID ASC