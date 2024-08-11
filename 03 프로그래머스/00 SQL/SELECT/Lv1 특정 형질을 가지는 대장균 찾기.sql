
-- Level 1

-- 대장균 개체의 수 AS COUNT
    -- 2번 형질을 보유하지 않으면서 (0010 = 2) 1번이나 3번 형질을 보유하고 있는 대장균 (0101 = 5)

SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA
WHERE NOT GENOTYPE & 2 AND GENOTYPE & 5S