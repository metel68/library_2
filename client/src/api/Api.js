import { BASE_URL } from './base';

const ERROR_REQUIRED = 'This field is required';

const createBook = async (bookInfo) => {
  // private int id;
  // private String isbn;
  // private String title;
  // private List<Author> authors = new ArrayList<>();
  // private List<Category> categories = new ArrayList<>();
  // private Publisher publisher;
  // private int year;
  // private int count;
  // private int size;
  // private String description;
  // private Date addedAt;
  // private String cover;
  const {
    authors,
    publishers,
    categories,
    title,
    year,
    count,
    size,
    description,
    cover,
    isbn,
  } = bookInfo;

  const data = {
    title,
    authors: authors.selected,
    categories: categories.selected,
    publisher: publishers.selected,
    year,
    count,
    size,
    description,
    cover,
    isbn,
  };

  const response = await fetch(`${BASE_URL}books`, {method: 'POST', body: JSON.stringify(data)});
  return response;
};

const editBook = async (id, bookInfo) => {
  // private int id;
  // private String isbn;
  // private String title;
  // private List<Author> authors = new ArrayList<>();
  // private List<Category> categories = new ArrayList<>();
  // private Publisher publisher;
  // private int year;
  // private int count;
  // private int size;
  // private String description;
  // private Date addedAt;
  // private String cover;
  const {
    authors,
    publishers,
    categories,
    title,
    year,
    count,
    size,
    description,
    cover,
    isbn,
  } = bookInfo;

  const data = {
    title,
    authors: authors.selected,
    categories: categories.selected,
    publisher: publishers.selected,
    year,
    count,
    size,
    description,
    cover,
    isbn,
  };

  const response = await fetch(`${BASE_URL}book?id=${id}`, {method: 'PUT', body: JSON.stringify(data)});
  return response;
};

const createNewAuthor = async (author) => {
  try {
    if (!author.length) {
      return {ok: false, ERROR_REQUIRED};
    }
    const response = await fetch(`${BASE_URL}authors`, {
      method: 'POST',
      body: JSON.stringify({fullName: author}),
    });
    const data = await response.json();
    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const createNewPublisher = async (publisher) => {
  try {
    if (!publisher.length) {
      return {ok: false, ERROR_REQUIRED};
    }
    const response = await fetch(`${BASE_URL}publishers`, {
      method: 'POST',
      body: JSON.stringify({name: publisher}),
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const formatData = data => ({
  key: data.id,
  text: data.fullName || data.name,
  value: data.id,
});

const getAuthors = async () => {
  try {
    const response = await fetch(`${BASE_URL}authors`);
    const json = await response.json();
    const data = json.map(formatData);
    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const getPublishers = async () => {
  try {
    const response = await fetch(`${BASE_URL}publishers`);
    const json = await response.json();
    const data = json.map(formatData);
    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const getCategories = async () => {
  try {
    const response = await fetch(`${BASE_URL}categories`);
    const json = await response.json();
    const data = json.map(formatData);
    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const createNewCategory = async (category) => {
  try {
    if (!category.length) {
      return {ok: false, ERROR_REQUIRED};
    }
    const response = await fetch(`${BASE_URL}categories`, {
      method: 'POST',
      body: JSON.stringify({name: category}),
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const getBooks = async () => {
  try {
    const response = await fetch(`${BASE_URL}books`);
    const json = await response.json();
    return {ok: true, data: json};
  } catch (error) {
    return {ok: false, error};
  }
};

const getBook = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}book?id=${id}`);
    const json = await response.json();
    return {ok: true, data: json};
  } catch (error) {
    return {ok: false, error};
  }
};

const searchBooks = async (query) => {
  try {
    const response = await fetch(`${BASE_URL}books?name=${query}`);
    const json = await response.json();
    return {ok: true, data: json};
  } catch (error) {
    return {ok: false, error};
  }
};

const deleteBook = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}book?id=${id}`, {
      method: 'DELETE',
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

export default {
  createBook,
  createNewAuthor,
  createNewPublisher,
  getAuthors,
  getPublishers,
  getCategories,
  getBooks,
  getBook,
  createNewCategory,
  searchBooks,
  editBook,
  deleteBook,
};
