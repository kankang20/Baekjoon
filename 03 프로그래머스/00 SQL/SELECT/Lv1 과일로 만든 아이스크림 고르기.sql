
-- Level 1

-- 아이스크림의 맛
    -- 상반기 아이스크림 총 주문량이 3000 이상
    -- 아이스크림의 주 성분이 과일
    -- 총 주문량을 기준으로 내림차순 정렬
    
SELECT HALF.FLAVOR
FROM FIRST_HALF as HALF, ICECREAM_INFO as INFO
WHERE HALF.TOTAL_ORDER >= 3000 AND INFO.INGREDIENT_TYPE = "fruit_based" AND HALF.FLAVOR = INFO.FLAVOR 
ORDER BY HALF.TOTAL_ORDER DESC