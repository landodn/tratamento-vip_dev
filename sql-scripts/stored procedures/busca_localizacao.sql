CREATE OR REPLACE FUNCTION busca_localizacao(latitude double precision, longitude double precision, out distancia double precision ) 
AS 
$$
    select (6371 * acos(cos(radians(-23.5710606)) * cos(radians(e.latitude)) * cos(radians(e.longitude) - radians(-51.4579695)) + sin(radians(-23.5710606)) * sin(radians(e.latitude ))))
      from salao_beleza sb
	 , endereco e
     where sb.id_endereco = e.id_endereco;
$$ 
LANGUAGE sql
IMMUTABLE 
RETURNS NULL ON NULL INPUT