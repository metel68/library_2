import { BASE_URL } from './base';

const createFav = async (bookId, userId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}&user=${userId}`, {
      method: 'POST',
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const deleteFav = async (bookId, userId) => {
  try {
    const response = await fetch(`${BASE_URL}favorites?book=${bookId}&user=${userId}`, {
      method: 'DELETE',
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

export default {
  createFav,
  deleteFav,
}