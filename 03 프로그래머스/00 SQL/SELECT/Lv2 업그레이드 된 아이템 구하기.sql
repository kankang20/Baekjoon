
-- Level 2

-- 아이템 ID, 아이템 명, 아이템의 희귀도
    -- 아이템의 희귀도가 'RARE'인 아이템들의 다음 업그레이드 아이템
    -- 아이템 ID를 기준으로 내림차순 정렬
    
SELECT ITEM_ID, ITEM_NAME, RARITY
FROM ITEM_INFO
WHERE ITEM_ID IN (SELECT T.ITEM_ID
                    FROM ITEM_INFO I, ITEM_TREE T
                    WHERE I.RARITY = 'RARE' AND I.ITEM_ID = T.PARENT_ITEM_ID)
ORDER BY ITEM_ID DESC