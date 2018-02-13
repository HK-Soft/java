package corejava.chpater8;

import corejava.chpater8.annotations.IsUnique;
import corejava.chpater8.annotations.Password;

//Mock object
public class ProductDTO {

	@IsUnique(columnName = "poroduc_code", tableName = "tb_products")
	@Password(maxSize = 8, minSize = 8, mustHaveNubmers = true, mustHaveUppercase = true)
	public String code;
}
