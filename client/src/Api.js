const BASE_URL = 'http://localhost:8080/ru.yuriandco.abis/';

const createBook = async (data) => {
  const response = await fetch(`${BASE_URL}books`, { method: 'POST', body: data });
  console.log(response);
  return response;
};

const createNewAuthor = async (author) => {
  try {
    const response = await fetch(`${BASE_URL}authors`, {
      method: 'POST',
      body: JSON.stringify({ fullName: author }),
    });
    const data = await response.json();
    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

const createNewPublisher = async (publisher) => {
  try {
    const response = await fetch(`${BASE_URL}publishers`, {
      method: 'POST',
      body: JSON.stringify({ name: publisher }),
    });

    const data = await response.json();

    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
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
    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

const getPublishers = async () => {
  try {
    const response = await fetch(`${BASE_URL}publishers`);
    const json = await response.json();
    const data = json.map(formatData);
    return { ok: true, data };
  } catch (error) {
    return { ok: false, error };
  }
};

export default {
  createBook,
  createNewAuthor,
  createNewPublisher,
  getAuthors,
  getPublishers,
};
