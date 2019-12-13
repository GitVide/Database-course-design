create table question
(
  id INT AUTO_INCREMENT primary key ,
  title VARCHAR(50),
  description text,
  gmt_create BIGINT,
  gmt_modified BIGINT,
  creator INT,
  comment_count INT DEFAULT 0,
  view_count int default 0,
  like_count int default 0,
  tag VARCHAR(256)
);