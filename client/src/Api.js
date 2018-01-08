const BASE_URL = 'http://localhost:8080/ru.yuriandco.abis/';

export const createBook = async (data) => {
  const response = await fetch(`${BASE_URL}books`, { method: 'POST', data });
  conosle.log(response);
  return response;
};
