package project.spring.hohotest.controller.admin.product;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import project.spring.hohotest.helper.PageHelper;
import project.spring.hohotest.helper.WebHelper;
import project.spring.hohotest.model.Product;
import project.spring.hohotest.service.ProductService;

@Controller
public class AdminProductListController {
	/** Helper 객체 선언 */
	@Autowired
	WebHelper web;
	@Autowired
	ProductService productService;
	@Autowired
	PageHelper pageHelper;
	
	@RequestMapping(value = "/admin/product/adminProductList.do")
	public ModelAndView doRun(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		web.init();
		
		int page = web.getInt("page", 1);
		int totalCount = 0;
		int maxPageNo = 0;
		List<Product> productList = null;
		Product product = new Product();
		
		try {
			totalCount = productService.selectProductCount(product);
			pageHelper.pageProcess(page, totalCount, 12, 5);

			product.setLimitStart(pageHelper.getLimitStart());
			product.setListCount(pageHelper.getListCount());
			
			productList = productService.selectProductList(product);
			
		} catch (Exception e) {
			return web.redirect(null, e.getLocalizedMessage());
		}
		
		maxPageNo = pageHelper.getTotalCount() - (pageHelper.getPage() - 1)	* pageHelper.getListCount();

		model.addAttribute("productList", productList);
		model.addAttribute("pageHelper", pageHelper);
		model.addAttribute("maxPageNo", maxPageNo);
		
		return new ModelAndView("admin/product/adminProductList");
	}
}