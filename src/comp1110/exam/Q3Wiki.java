package comp1110.exam;

import java.util.*;

/**
 * COMP1110 Exam, Question 3.1
 * <p>
 * This class represents a wiki: a collection of linked articles that is
 * contributed to by multiple editors.
 * In this wiki, each article has a unique ID (integer), a name (String) and a
 * category (String). Multiple articles may have the same category.
 * Articles may link to other articles in the wiki; each article has at most
 * one link to each other article.
 * Each article also has a set of editors (the users who have edited the
 * article). An editor is represented by their username (String),
 * and each editor may have edited zero or more articles.
 */
public class Q3Wiki {
	class WikiInfo{
		int id;
		String name;
		String category;
		Set<String> editors;
		Set<Integer> links=new HashSet<>();
		public WikiInfo(int id, String name, String category, Set<String> editors) {
			super();
			this.id = id;
			this.name = name;
			this.category = category;
			this.editors = editors;
		}
	}
	Map<Integer, WikiInfo> dict=new HashMap<>();
    /**
     * Add a new article to this wiki. If the given article ID already exists,
     * do not modify this wiki.
     *
     * @param id       the ID of the article
     * @param name     the name of the article
     * @param category the category of the article
     * @param editors  the set of editors of the article
     * @return true if the article was added to this wiki, or false if the
     * article was not added (because it already exists)
     */
    public boolean addArticle(int id, String name, String category, Set<String> editors) {
        // FIXME complete this method
        if(dict.get(id)==null) {
        	WikiInfo value=new WikiInfo(id, name, category, editors);
        	dict.put(id, value);
        	return true;
        }
        return false;
    }

    /**
     * Adds a link from one article to another in this wiki.
     *
     * @param fromArticle the article to link from
     * @param toArticle   the article to link to
     * @return true if the link was added, or false if the link already exists
     */
    public boolean addLink(int fromArticle, int toArticle) {
        // FIXME complete this method
    	if(dict.get(fromArticle).links.contains(toArticle))
    		return false;
    	dict.get(fromArticle).links.add(toArticle);
    	return true;
    }

    /**
     * Delete the specified article from this wiki.
     * All information associated with this article is deleted, including
     * links to other articles and incoming links from other articles.
     *
     * @param id the ID of the article to be deleted
     * @return true if the specified article was found and deleted,
     * or false if the specified article was not found in this wiki
     */
    public boolean deleteArticle(int id) {
        // FIXME complete this method
    	if(dict.get(id)==null)
    		return false;
    	dict.remove(id);
    	for(Map.Entry<Integer, WikiInfo> entry:dict.entrySet()) {
    		if(entry.getValue().links.contains(id))
    			entry.getValue().links.remove(id);
    	}
        return true;
    }

    /**
     * @return the total number of articles in this wiki
     */
    public int getArticleCount() {
        // FIXME complete this method
        return dict.size();
    }

    /**
     * Gets the set of articles that were edited by the given editor.
     *
     * @param editor the username of the editor
     * @return the set of articles that were edited by the given editor
     * (if the editor has not edited any articles, this will be the empty set)
     */
    public Set<Integer> getArticlesEditedBy(String editor) {
        // FIXME complete this method
    	Set<Integer> editorSet=new HashSet<>();
    	for(Map.Entry<Integer, WikiInfo> entry:dict.entrySet()) {
    		if(entry.getValue().editors.contains(editor))
    			editorSet.add(entry.getKey());
    	}
        return editorSet;
    }

    /**
     * Gets the set of all articles for the given category.
     *
     * @param category the name of the category to search for
     * @return the set of all articles in the given category
     * (if there are no articles for the category, this will be the empty set)
     */
    public Set<Integer> getArticlesForCategory(String category) {
        // FIXME complete this method
        Set<Integer> cateSet=new HashSet<>();
        for(Map.Entry<Integer, WikiInfo> entry:dict.entrySet()) {
    		if(entry.getValue().category.equals(category))
    			cateSet.add(entry.getKey());
    	}
        return cateSet;
    }

    /**
     * Gets the largest number of incoming links to any article.
     * For example, if there are four articles in this wiki:
     * - "Ursula" (category: Person) links to "Earthsea" and "Darkness"
     * - "Earthsea" (category: Book) links to "Ursula" and "Ged"
     * - "Darkness" (category: Book) links to "Ursula"
     * - "Ged" (category: Person) links to "Ursula" and "Earthsea"
     * then getMaxIncomingLinks() == 3 (for the article "Ursula")
     *
     * @return the largest number of incoming links to any article
     */
    public int getMaxIncomingLinks() {
        // FIXME complete this method
    	Set<Integer> linkSet=new HashSet<>();
        for(Map.Entry<Integer, WikiInfo> entry:dict.entrySet()) {
    		for(Integer i:entry.getValue().links)
    			linkSet.add(i);
    	}
        int maxx=0;
        for(Integer i:linkSet) {
        	int cnt=0;
        	for(Map.Entry<Integer, WikiInfo> entry:dict.entrySet()) {
        		if(entry.getValue().links.contains(i))
        			cnt++;
        	}
        	if(cnt>maxx)	maxx=cnt;
        }
        return maxx;
    }

    /**
     * Gets the total number of links between articles of different categories.
     * For example, if there are three articles in this wiki:
     * - "Charlotte" (category: Person) links to "Jane"
     * - "Jane" (category: Book) links to "Charlotte"
     * - "Sargasso" (category: Book) links to "Charlotte" and "Jane"
     * then the number of cross-category links is 3:
     * - Charlotte -> Jane
     * - Jane -> Charlotte
     * - Sargasso -> Charlotte
     *
     * @return the total number of cross-category links
     */
    public int getNumCrossCategoryLinks() {
        // FIXME complete this method
    	int crossCategoryLinks = 0;
        for (Map.Entry<Integer, WikiInfo> entry : dict.entrySet()) {
            for (Integer linkedArticleId : entry.getValue().links) {
                // Check if the linked article belongs to a different category
                if (!entry.getValue().category.equals(dict.get(linkedArticleId).category)) {
                    crossCategoryLinks++;
                }
            }
        }
        return crossCategoryLinks;
    }

    /**
     * Get the number of different categories of article that the given editor
     * has edited.
     * For example, if editor "Okonkwo" has edited three articles:
     * - "Chinua" (category: Person)
     * - "Apart" (category: Book)
     * - "Ease" (category: Book)
     * then getNumCategoriesEdited("Okonkwo") == 2.
     *
     * @param editor the username of the editor to search for
     * @return the number of distinct categories of article that the specified editor has edited
     */
    public int getNumCategoriesEdited(String editor) {
        // FIXME complete this method
    	Set<String> categoriesEdited = new HashSet<>();
        for (Map.Entry<Integer, WikiInfo> entry : dict.entrySet()) {
            if (entry.getValue().editors.contains(editor)) {
                categoriesEdited.add(entry.getValue().category);
            }
        }
        return categoriesEdited.size();
    }

    /**
     * Get the maximum number of articles in any category.
     * For example, if there are four articles in the wiki:
     * - "Chinua" (category: Person)
     * - "Apart" (category: Book)
     * - "Ease" (category: Book)
     * - "Wrestling" (category: Sport)
     * then getMaxArticlesInCategory() == 2 (for the category "Book")
     *
     * @return the largest number of articles in any category
     */
    public int getMaxArticlesInCategory() {
        // FIXME complete this method
    	Map<String, Integer> categoryCount = new HashMap<>();
        for (Map.Entry<Integer, WikiInfo> entry : dict.entrySet()) {
            String category = entry.getValue().category;
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }

        int maxArticlesInCategory = 0;
        for (int count : categoryCount.values()) {
            maxArticlesInCategory = Math.max(maxArticlesInCategory, count);
        }

        return maxArticlesInCategory;
    }
}
