import { BASE_URL } from './base';

const registerUser = async ({email, ...rest}) => {
  try {
    const response = await fetch(`${BASE_URL}users`, {
      method: 'POST',
      body: JSON.stringify({username: email, ...rest}),
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const editUser = async (id, {email, ...rest}) => {
  try {
    const response = await fetch(`${BASE_URL}user?id=${id}`, {
      method: 'PUT',
      body: JSON.stringify({username: email, ...rest}),
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

const auth = async ({email, password}) => {
  const response = await fetch(`${BASE_URL}login`, {
    method: 'POST',
    body: JSON.stringify({username: email, password}),
  });

  const data = await response.json();
  if (data.message === 'fail') {
    return {ok: false, error: 'Ошибка авторизации'};
  }
  return {ok: true, data};
};

const getUser = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}user?id=${id}`);
    const json = await response.json();
    return {ok: true, data: json};
  } catch (error) {
    return {ok: false, error};
  }
};

const getUsers = async () => {
  try {
    const response = await fetch(`${BASE_URL}users`);
    const json = await response.json();
    return {ok: true, data: json};
  } catch (error) {
    return {ok: false, error};
  }
};

const deleteUser = async (id) => {
  try {
    const response = await fetch(`${BASE_URL}user?id=${id}`, {
      method: 'DELETE',
    });

    const data = await response.json();

    return {ok: true, data};
  } catch (error) {
    return {ok: false, error};
  }
};

export default {
  registerUser,
  editUser,
  auth,
  getUser,
  getUsers,
  deleteUser
}