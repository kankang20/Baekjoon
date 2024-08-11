
-- Level 1

-- 동물의 ID
    -- 이름이 있는 동물
    -- ID를 기준으로 오름차순 정렬
    
SELECT ANIMAL_ID 
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
ORDER BY ANIMAL_ID ASC