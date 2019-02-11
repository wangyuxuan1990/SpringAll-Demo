SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `SNO` varchar(3) NOT NULL,
  `SNAME` varchar(10) NOT NULL,
  `SSEX` char(2) NOT NULL,
  `DATASOURCE` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('001', 'KangKang', 'M', 'mysql_one');
INSERT INTO `student` VALUES ('002', 'Mike', 'M', 'mysql_one');