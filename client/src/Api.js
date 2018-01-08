const BASE_URL = 'http://localhost:8080/ru.yuriandco.abis/';

const createBook = async (data) => {
  const response = await fetch(`${BASE_URL}books`, { method: 'POST', body: data });
  console.log(response);
  return response;
};

const createNewAuthor = async (author) => {
  const response = await fetch(`${BASE_URL}authors`, {
    method: 'POST',
    body: { fullname: author },
  });
  const data = await response.json();
  console.log(data);
  return response;
};

const createNewPublisher = async (publisher) => {
  const response = await fetch(`${BASE_URL}publishers`, {
    method: 'POST',
    body: { name: publisher },
  });

  const data = await response.json();

  return data;
};

export default {
  createBook,
  createNewAuthor,
  createNewPublisher,
};
