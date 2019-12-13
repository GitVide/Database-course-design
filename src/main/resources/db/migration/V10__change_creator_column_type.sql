alter table question modify creator BIGINT null;
alter table comment modify commentator BIGINT not null comment '评论人ID';
