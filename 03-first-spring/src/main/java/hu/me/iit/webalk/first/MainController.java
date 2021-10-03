package hu.me.iit.webalk.first;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("articles")
public class MainController {

	private final List<Article> articles = new ArrayList<>();


	@GetMapping("")
	public List<Article> getAllArticles() {
		return articles;
	}

	@GetMapping("/{id}")
	public Article getArticle(@PathVariable("id") String id) {
		for (Article ar: articles ) {
			if (ar.getId().equals(id)) {
				return ar;
			}
		}
		return null;
	}

	@PostMapping("")
	public void newArticle(@RequestBody @Valid Article article) {
		articles.add(article);
	}

	@PutMapping("/{id}")
	public void replaceArticle(@PathVariable("id") String id,
						@RequestBody @Valid Article article) {
		for (Article ar: articles ) {
			if (ar.getId().equals(id)) {
				ar.setAuthor(article.getAuthor());
				ar.setAge(article.getAge());
			}
		}
	}

	@DeleteMapping ("/{id}")
	public void deleteArticle(@PathVariable("id") String id) {
		int found = -1;

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getId().equals(id)) {
				found = i;
			}
		}

		if (found != -1) {
			articles.remove(found);
		}
	}
}
