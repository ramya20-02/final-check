-- Include table data insertion, updation, deletion and select scripts
-- -------------------------------------------------------------------
-- Adding Movie List to Movie Cruiser Table---------------------------
-- -------------------------------------------------------------------
INSERT INTO movie_list
VALUES
(1,'Avatar',2787965087,'Yes','2017-03-15','Science Fiction','Yes'),
(2,'The Avengers',1518812988,'Yes','2017-12-23','Superhero','No'),
(3,'Titanic',2187463944,'Yes','2017-08-21','Romance','No'),
(4,'Jurrasic World',1671713208,'No','2017-07-02','Science Fiction','Yes'),
(5,'Avengers:End Game',2750760348,'Yes','2022-11-02','Superhero','Yes');

-- -------------------------------------------------------------------
-- Displaying Admin Movie List----------------------------------------
-- -------------------------------------------------------------------
SELECT * FROM movie_list;

-- -------------------------------------------------------------------
-- Updating Admin Movie List------------------------------------------
-- -------------------------------------------------------------------
UPDATE movie_list
SET mo_title='Conjuring',mo_box_office=3214569870,mo_active='Yes',mo_date_of_launch='2017-05-02',mo_genre='Horror',mo_has_teaser='Yes'
WHERE mo_id=1;

-- -------------------------------------------------------------------
-- Displaying Updated Movie List--------------------------------------
-- -------------------------------------------------------------------
SELECT * FROM movie_list;

-- -------------------------------------------------------------------
-- Creating Users-----------------------------------------------------
-- -------------------------------------------------------------------
INSERT INTO user(us_id,us_name)
VALUES(1,'Kiran'),(2,'Anil');

-- -------------------------------------------------------------------
-- Displaying User List-----------------------------------------------
-- -------------------------------------------------------------------
SELECT * FROM user;

-- -------------------------------------------------------------------
-- Customer Movie List------------------------------------------------
-- -------------------------------------------------------------------
SELECT mo_title,mo_box_office,mo_genre,mo_has_teaser
FROM movie_list
WHERE mo_active='Yes' AND mo_date_of_launch  <= (SELECT(curdate())); 

-- -------------------------------------------------------------------- 
-- Favorite Movie List-------------------------------------------------
-- --------------------------------------------------------------------
INSERT INTO favorite(ft_us_id,ft_pr_id)
VALUES (1,2);
INSERT INTO favorite(ft_us_id,ft_pr_id) 
VALUES (1,3);

SELECT * FROM favorite;

-- --------------------------------------------------------------------
-- To View Favorite----------------------------------------------------
-- --------------------------------------------------------------------
SELECT mo_title,mo_has_teaser, mo_box_office  
FROM movie_list
INNER JOIN favorite 
ON ft_pr_id=mo_id
WHERE ft_us_id=1;

-- --------------------------------------------------------------------
--  Total Calculation of Number of Favorites---------------------------
-- --------------------------------------------------------------------
SELECT count(mo_box_office) as NumberofFavorites
FROM  movie_list
INNER JOIN favorite 
ON ft_pr_id=mo_id
WHERE ft_us_id=1;

-- --------------------------------------------------------------------
-- To Display Favorite-------------------------------------------------
-- --------------------------------------------------------------------
SELECT *FROM favorite;

-- --------------------------------------------------------------------
-- To Delete Movie From Favorite---------------------------------------
-- --------------------------------------------------------------------
DELETE FROM favorite 
WHERE ft_us_id=1 AND ft_pr_id=3 limit 1;

-- --------------------------------------------------------------------
-- To Display Favorite-------------------------------------------------
-- --------------------------------------------------------------------
SELECT *FROM favorite;

-- --------------------------------------------------------------------
--  To View Favorite after Deleting------------------------------------
-- --------------------------------------------------------------------
SELECT mo_title,mo_has_teaser, mo_box_office  
FROM movie_list
INNER JOIN favorite 
ON ft_pr_id=mo_id
WHERE ft_us_id=1;

-- --------------------------------------------------------------------
--   Total Calculation of Number of Favorites--------------------------
-- --------------------------------------------------------------------
SELECT count(mo_box_office) as NumberofFavorites
FROM  movie_list
INNER JOIN favorite 
ON ft_pr_id=mo_id
WHERE ft_us_id=1;

-- --------------------------------------------------------------------
-- To Display Favorite After Deleting----------------------------------
-- --------------------------------------------------------------------
SELECT *FROM favorite;