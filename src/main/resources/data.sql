/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  LucasRoman
 * Created: 28/09/2017
 */
INSERT INTO `personas` ( `apellido`, `descripcion`, `dni`, `mail`, `nombre`, `tel_cel`, `tel_fijo`) VALUES ( 'Roman', 'asdasd', '34970725', 'lucasroman2@gmail.com', 'Lucas', '1567995906', '47451426');
INSERT INTO `personas` ( `apellido`, `descripcion`, `dni`, `mail`, `nombre`, `tel_cel`, `tel_fijo`) VALUES ( 'Gordon', 'asdasd', '34346726', 'gordon2@gmail.com', 'Snow', '1567725989', '47456479');

INSERT INTO `usuarios` ( `permiso`, `psw`, `usuario`) VALUES ( '1', 'admin', 'lucas');
INSERT INTO `usuarios` ( `permiso`, `psw`, `usuario`) VALUES ( '1', 'admin', 'admin');

INSERT INTO `suite` (  `nombre`, `ambientes`, `cant_personas`, `costo_por_dia`) VALUES ( 'Cabania 1 ', 3, 6, 450);
INSERT INTO `suite` (  `nombre`, `ambientes`, `cant_personas`, `costo_por_dia`) VALUES ( 'Cabania 2 ', 3, 6, 450);
INSERT INTO `suite` (  `nombre`, `ambientes`, `cant_personas`, `costo_por_dia`) VALUES ( 'Cabania 3 ', 2, 4, 350);
INSERT INTO `suite` (  `nombre`, `ambientes`, `cant_personas`, `costo_por_dia`) VALUES ( 'Cabania 4 ', 2, 4, 350);