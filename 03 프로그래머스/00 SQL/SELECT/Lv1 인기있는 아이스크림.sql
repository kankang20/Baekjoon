
-- Level 1

-- 아이스크림의 맛 
    -- 총 주문량을 기준으로 내림차순
    -- 총주문량이 같다면 출하 번호를 기준으로 오름차순

SELECT FLAVOR 
FROM FIRST_HALF
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC